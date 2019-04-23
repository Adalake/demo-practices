-----------
PiCluster
-----------

.. code ::

    PiCluster is a cluster utility lib which provides reactive programming based functions about task definning, submitting and scheduling.
::

  └── cluster
      ├── __init__.py
      ├── backend
      ├── cli
      ├── config
      ├── database
      ├── dispatcher.py 
      ├── exceptions
      ├── hashfs
      ├── interactive
      ├── primitives
      ├── taskstream
      └── time

Primitives in PiCluster
------------------------

.. code:: python    

    import rx
    from rx.subjects import Subject
    from rx import Observable
    from rx import operators as ops
    from functools import partial

    from dxl.cluster.taskstream.primitive import cli, func, Resource, submit
    from pathlib import Path

    from dxl.cluster.taskstream.combinator import sequential, parallel
    from dxl.cluster.taskstream.cli_tasks import ls, mv, mkdir, mkdir_n_return, cp ,rm
    from dxl.cluster.taskstream.primitive import Resource, Query
    from dxl.cluster.taskstream.monte_carlo import MonteCarloSimulation
    from dxl.cluster.database.model.schema import Task, taskSchema
    from dxl.cluster.backend.slurm.slurm import SlurmSjtu
    from dxl.cluster.database.model.resources import sync_resources

func -- Turn a function to observable
---------------------------------------

.. code:: python

    from dxl.cluster.taskstream.primitive import func

    # Let's say we have a self-defined function to calculate square root.
    def sqrt(x, o=None, s=None):
        def improve_guess(G):
           return avg(G, x/G)

        def good_enough(G):
           return abs(G*G - x) < 0.00000000001
    
        def try_(G):
           print(f"try {G}")
           if good_enough(G):
              return G
           return try_(improve_guess(G))
    
        return try_(1)

    >>> sqrt(2)
    >>> try 1
        try 1.5
        try 1.4166666666666665
        try 1.4142156862745097
        try 1.4142135623746899
        1.4142135623746899


     >>> func(partial(sqrt, 2)).subscribe(print, print, print)
     >>> try 1
        try 1.5
        try 1.4166666666666665
        try 1.4142156862745097
        try 1.4142135623746899
        <rx.disposable.disposable.Disposable at 0x7fa5ba7c6b38>

cli -- Turn a CLI command to observable
----------------------------------------

.. code:: python

    >>> cli('pwd').subscribe(print)
    >>> ['/mnt/gluster/qinglong/tasks.dev']
    <rx.disposable.disposable.Disposable at 0x7fd698103908>

Task -- formalization of task
-------------------------------

.. code:: python

    >>> taskSchema.declared_fields.keys()
    >>> dict_keys(['id', 'state', 'create', 'submit', 'finish', 'depends', 'scheduler', 'backend', 'workdir', 'id_on_backend', 'state_on_backend', 'worker', 'script', 'inputs', 'outputs', 'fn'])

    # sleep_1s.sh can be any scripts doing any kinds of tasks.
    >>> sleep_1s = Task(script='/mnt/gluster/qinglong/tasks.dev/sleep_1s.sh', workdir=".")

submit & Slurm / SlurmSjtu -- submit a Task to a formulation of backends
-------------------------------------------------------------------------

.. code:: python

    submit(sleep_1s, backend=SlurmSjtu).subscribe(print)

CLI tasks
----------

ls, mv, mkdir, mkdir_n_return, cp ,rm

.. code:: python

    >>> ls(".").subscribe(print)

    >>> mkdir_n_return(<any dir in str or Path>).subscribe(print)

    >>> rm(<any dir in str or Path>).subscribe(print)
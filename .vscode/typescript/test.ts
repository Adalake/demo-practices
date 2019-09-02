export enum Direction {
  X = "x",
  Y = "y"
}

export enum RotationSpeed {
  x = 10,
  y = 12,
  z = 14
}

export interface ScanScout {
  name: string;
  start_position: number;
  direction: Direction;
  rotation_speed: RotationSpeed;
}

export const getConfigTest = function() {};

interface Foo {
  fooH: string;
}
// 返回类型注解:
function foo(sample: Foo): Foo {
  return sample;
}

// -------------------------------------

// export interface FormConfigDef {
//     name: string;
//     unit: string;
//     step: number;
//     min: number;
//     max: number;
// }
// export const getConfig = function(
//     name: string,
//     unit: string,
//     step: number,
//     min: number,
//     max: number,
// ):FormConfigDef {
//     return {name, unit, step, min, max: ggg()}
// }

// export namespace formConfigConstructor {
//     export const tubeCurrentConfig = getConfig("hh", "hdhd", 1, 12, 21);
//     export const rotationSpeedConfig = getConfig("ddd","erer", 55, 66, 77);
// }

// -------------------------------------

// 以下是硬编码
// export const tubeCurrentConfigx = {
//         name: "hh",
//         unit: "hdhd",
//         step: 1,
//         min: 12,
//         max: 21
// }
// export const rotationSpeedConfigx = {
//     name: "ddd",
//     unit: "erer",
//     step: 55,
//     min: 66,
//     max: 77
// }

export interface FormConfigDef<ValueType, MarkType> {
  name: string;
  unit: string;
  step: number;
  min: number;
  max: number;
  value: number;
  mark: MarkType;
  //   formatter: (value: ValueType) => string;
}
export const getConfig = function<ValueType, MarkType>(
  name: string,
  unit: string,
  step: number,
  min: number,
  max: number,
  value: string,
  mark: Array<number>,
  valueSwicher: (value: string) => number, 
  markSwitcher: (mark: Array<number>) => MarkType
): FormConfigDef<ValueType, MarkType> {   
  return {
    name,
    unit,
    step,
    min,
    max,
    value: valueSwicher(value), // ? 调用这个函数并返回 ValueTpye ,为什么直接 value 不可以  ====> 因为这是值类型
    mark: markSwitcher(mark)
    // formatter: (input: ValueType) => `${input} ${unit}`,
  };
};

export namespace formConfigConstructor {
  export const tubeCurrentConfig = getConfig(
    "hh",
    "hdhd",
    1,
    12,
    21,
    "ddd",
    [1, 2, 2, 2],
    (value: string) => Number(value),
    (mark: Array<number>) => mark.toString()
  );
}

// const markO = {
//     1: '1',
//     2: '2'
// }
// fomatterO(x: number): string {
//     return "${x} hha";
// }
// mark 的 API:  { number: string/HTML }
// formatter 的API:  (value: number) => string

// ================================================================

export interface PostureRecord {
    src: string;
    id: Posture;
}

export const enum Posture {
    H = 'h',
    N = 'n',
    T = 't'
}

export const AllPostureRecord: PostureRecord[] = [
    {
        src: "dddd",
        id: Posture.H
    },
    {
        src: "dsde",
        id: Posture.N
    }
]

interface SS<T extends { id: any }> {
    data: T,
    active: boolean
}

class X implements OnInit {   //加这句仅为了下面 regions 编译不报错
    regions: SS<PostureRecord>[] = AllPostureRecord.map((s) => ({
        data: s,
        active: false,
      }));  
}

// ================================================================

import requests



url = 'https://www.lagou.com/jobs/positionAjax.json?px=default&needAddtionalResult=false'



HEADERS = {

   'Accept': 'application/json, text/javascript, */*; q=0.01',

   'Accept-Encoding': 'gzip, deflate, br',

   'Accept-Language': 'zh-CN',

   'Cache-Control': 'no-cache',

   'Connection': 'Keep-Alive',

   'Content-Length': '25',

   'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',

   'Host': 'www.lagou.com',

   'Origin': 'https://www.lagou.com',

   'Referer': 'https://www.lagou.com/jobs/list_python?px=default&city=%E5%85%A8%E5%9B%BD',

   'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/18.17763',

   'X-Anit-Forge-Code': '0',

   'X-Anit-Forge-Token': 'None',

   'X-Requested-With': 'XMLHttpRequest'

}



form_data = {'first': 'true',

             'pn': 'i',

             'kd': 'Python'

             }



def getJobs():

    res = requests.post(url=url, headers=HEADERS, data=form_data)

    result = res.json()

    jobs = result['content']['positionResult']['result']

    return jobs



for job in getJobs():

    

    job=[]

    print(job['city']+ ':' + job['education'])
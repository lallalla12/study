import requests
import json

url = 'http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst'
params ={'serviceKey' : 'XebtN3YUICLzC2/OUJn+TLJmRJWTk05sAShd9vcGz+Fi+3nS7/GdBKZJ3VOB9LUDk0KILiyXcWg2Dy/jMdLWWg==', 
         'pageNo' : '1', 
         'numOfRows' : '10', 
         'dataType' : 'JSON', 
         'base_date' : '20250422', 
         'base_time' : '0500', 
         'nx' : '104', 
         'ny' : '83' }

response = requests.get(url, params=params)
# print(response.content)   xml로 결과보기
# print(response.json())
# 결과 출력
if response.status_code == 200 :
    data = response.json()
    for item in data['response']['body']['items']['item']:
        print(item['category'], '->',item['fcstValue'],'(',item['fcstDate'],'',item['fcstTime'],')')
else : print("요청실패",response.status_code)
    
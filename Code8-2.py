import pymysql

# 전역변수 선언부
conn, cur = None, None
data1, data2, data3, data4 = "", "", "", ""
row = None


# 메인코드
conn = pymysql.connect(host='localhost',user = 'root',password ='1234',db = 'SOLODB',charset = 'utf8')
cur = conn.cursor()

# SELECT문으로 테이블 조회 조회한 결과는 CUR에 저장
cur.execute("SELECT * FROM USERTABLE")

print("사용자ID         사용자 이름             이메일          출생연도")
print("---------------------------------------------------------------")


while (True) :
    # fetchone() 함수로 결과를 한 행씩 추출함 while문 안에 있으므로 무한반복
    row = cur.fetchone()
    # 조회한 결과가 없으면 none 값을 반환하여 while문 빠져나옴
    if row == None :
        break;
    data1 = row[0]
    data2 = row[1]
    data3 = row[2]
    data4 = row[3]

# fetchone()함수로 조회된 결과가 저장된 row 변수에는 튜플 형식으로 각 행 데이터가 저장됨.
print("%5s  %15s    %20s    %d" % (data1, data2, data3, data4))


conn.close()
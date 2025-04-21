import pymysql

# 전역변수 선언부
conn, cur = None, None
data1, data2, data3, data4 = "", "", "", ""
sql = ""


# 메인코드
conn = pymysql.connect(host='localhost',user = 'root',password ='1234',db = 'SOLODB',charset = 'utf8')
cur = conn.cursor()


# 무한반복하면서 data1~4를 입력받음, 만약 데이터를 아무것도 입력하지 않고 enter키를 입력하면 while문을 빠져나감
while (True) :
    data1 = input("사용자 ID ==>")
    if data1 == "" :
        break;
    data2 = input("사용자 이름 ==>")
    data3 = input("사용자 이메일 ==>")
    data4 = input("사용자 출생연도 ==>")
    # 마지막 data4는 정수이므로 작은따옴표로 묶으면안됨.
    sql = "INSERT INTO userTable VALUES('"+ data1 + "', '" + data2 + "', '"+ data3 + "', " + data4 + ")"
    cur.execute(sql)


conn.commit()
conn.close()
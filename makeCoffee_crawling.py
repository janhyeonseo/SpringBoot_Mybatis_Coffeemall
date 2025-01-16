from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.support.ui import WebDriverWait
from bs4 import BeautifulSoup
import time
import cx_Oracle

# 오라클 데이터베이스 연결 설정
dsn = cx_Oracle.makedsn("LAPTOP-0MHROSDQ", 1521, service_name="XE")
connection = cx_Oracle.connect(user="system", password="1234", dsn=dsn)
cursor = connection.cursor()

# 웹 드라이버 설정
options = Options()
options.add_argument("--start-maximized")
options.add_experimental_option("detach", True)
service = Service()
driver = webdriver.Chrome(service=service, options=options)

# 정보수집 할 페이지 접속
url = "https://www.starbucks.co.kr/menu/drink_list.do"
driver.get(url)

# 페이지 로드 대기
wait = WebDriverWait(driver, 10)

# 음료 목록 전체 크롤링
def get_drink_data():
    drinks = driver.find_elements(By.CSS_SELECTOR, ".goDrinkView")
    
    for index, drink in enumerate(drinks):
        try:
            # 음료 클릭
            drink.click()
            time.sleep(2)
            
            # 데이터 추출
            try:
                pimg = driver.find_element(By.XPATH, '//*[@id="container"]/div[2]/div[1]/div[1]/div[1]/p[1]/a/img').get_attribute('src')
            except:
                pimg = "정보가 없습니다"
            
            try:
                pname_full = driver.find_element(By.XPATH, '//*[@id="container"]/div[2]/div[1]/div[2]/div[1]/h4')
                pname_html = pname_full.get_attribute("innerHTML")
                # BeautifulSoup으로 HTML 파싱
                soup = BeautifulSoup(pname_html, "html.parser")
                # span 태그 제거
                for span in soup.find_all("span"):
                    span.decompose()  # span 태그 삭제

                # 순수 텍스트 추출
                pname = soup.get_text(strip=True)
            except:
                pname = "정보가 없습니다"

            try:
                pename = driver.find_element(By.XPATH, '//*[@id="container"]/div[2]/div[1]/div[2]/div[1]/h4/span').text
            except:
                pename = "정보가 없습니다"

            try:
                pdesc = driver.find_element(By.XPATH, '//*[@id="container"]/div[2]/div[1]/div[2]/div[1]/p').text
            except:
                pdesc = "정보가 없습니다"

            try:
                psize = driver.find_element(By.XPATH, '//*[@id="product_info01"]/p').text
            except:
                psize = "정보가 없습니다"
            
            try:
                pinfo = driver.find_element(By.XPATH, '//*[@id="container"]/div[2]/div[1]/div[2]/form/fieldset/div/div[3]/p').text
            except:
                pinfo = "정보가 없습니다"

            try:
                pprice = 5000 

                # 데이터베이스에 삽입
                insert_sql = """
                    INSERT INTO product (pid, pimg, pname, pename, pdesc, psize, pinfo, pprice)
                    VALUES (TO_CHAR(pid_idx.nextval), :pimg, :pname, :pename, :pdesc, :psize, :pinfo, :pprice)
                """
                cursor.execute(insert_sql, {
                    "pimg": pimg,
                    "pname": pname[:30],
                    "pename": pename[:60],
                    "pdesc": pdesc[:300],
                    "psize": psize[:100],
                    "pinfo": pinfo[:300],
                    "pprice": pprice
                })
                connection.commit()
                print("DB 삽입 성공!")
            except cx_Oracle.DatabaseError as e:
                print(f"DB 삽입 오류: {e}")

            # 커밋
            connection.commit()

            print("이미지 : ", pimg)
            print("이름 : ", pname)
            print("영어이름 : ", pename)
            print("상세정보 : ", pdesc)
            print("사이즈 : ", psize)
            print("안내사항 : ", pinfo)
            print("-"*50)
            
            # 전 페이지로 돌아가기
            driver.back()
            time.sleep(2)
            
            # 새로 음료 목록 요소 로드
            drinks = driver.find_elements(By.CSS_SELECTOR, ".goDrinkView")
        except Exception as e:
            print(f"에러 발생: {e}")
            continue
    
    return drink_data

# 크롤링 실행
drink_info = get_drink_data()

print(f"크롤링 완료!")

# 드라이버 종료
driver.quit()

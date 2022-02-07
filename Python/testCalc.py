import time
import unittest
from appium import webdriver
from selenium.webdriver.common.by import By


class WhatsappTests(unittest.TestCase):
    def setUp(self):
        desired_caps = {}
        desired_caps['platformName'] = 'android'
        desired_caps['udid'] = 'emulator-5554'
        desired_caps['deviceName'] = 'Pixel 3'
        desired_caps['noReset'] = 'true'
        desired_caps['appPackage'] = 'com.android.calculator2'
        desired_caps['appActivity'] = 'com.android.calculator2.Calculator'

        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub', desired_caps)

    def tearDown(self):
        self.driver.quit()

    def test_addition(self):
        num2 = self.driver.find_element(By.ID, "com.android.calculator2:id/digit_2")
        num2.click()
        time.sleep(1)

        plus = self.driver.find_element(By.ID, "com.android.calculator2:id/op_add")
        plus.click()

        num3 = self.driver.find_element(By.ID, "com.android.calculator2:id/digit_3")
        num3.click()

        equal = self.driver.find_element(By.ID, "com.android.calculator2:id/eq")
        equal.click()

        time.sleep(4)

        result = self.driver.find_element(By.ID, "com.android.calculator2:id/result")
        print(result.text)

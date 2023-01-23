# -*- coding: utf-8 -*-



from PyQt5 import QtCore, QtGui, QtWidgets
import sys, res
import sqlite3
import datetime


class Ui_loginForm(object):


    def signUp(self):

        dbConnection = sqlite3.connect('ShopLens.db')
        cursor = dbConnection.cursor()
        createTableUsers = """CREATE TABLE IF NOT EXISTS UserTable (UserName VARCHAR(255), PassWord VARCHAR(255), UserType  VARCHAR(255), AccountCreatedOn TIMESTAMP);"""
        cursor.execute(createTableUsers)
        insertData = """INSERT INTO UserTable VALUES (?, ?, ?, ?);"""
        cursor.execute(insertData, (self.userNamelineEdit.text(), self.passwordlineEdit.text(), 'Admin', datetime.datetime.now()))
        dbConnection.commit()
        cursor.close()
        dbConnection.close()
    

    def setupUi(self, loginForm):
        loginForm.setObjectName("loginForm")
        loginForm.resize(455, 548)
        font = QtGui.QFont()
        font.setPointSize(11)
        loginForm.setFont(font)
        self.widget = QtWidgets.QWidget(loginForm)
        self.widget.setGeometry(QtCore.QRect(0, 0, 471, 556))
        self.widget.setObjectName("widget")
        self.imageLabel = QtWidgets.QLabel(self.widget)
        self.imageLabel.setGeometry(QtCore.QRect(-10, 0, 481, 556))
        self.imageLabel.setStyleSheet("border-image: url(:/images/basketofstrawberries.jpg);\n"
"\n"
"")
        self.imageLabel.setText("")
        self.imageLabel.setObjectName("imageLabel")
        self.blurLabel = QtWidgets.QLabel(self.widget)
        self.blurLabel.setGeometry(QtCore.QRect(0, 0, 471, 561))
        self.blurLabel.setStyleSheet("background-color: qlineargradient(spread:pad, x1:0, y1:0, x2:0, y2:0.715909, stop:0 rgba(0, 0, 0, 9), stop:0.375 rgba(0, 0, 0, 50), stop:0.835227 rgba(0, 0, 0, 75));\\n\"\n"
"\"border-radius:20px;\n"
"")
        self.blurLabel.setText("")
        self.blurLabel.setObjectName("blurLabel")
        self.outlineLabel = QtWidgets.QLabel(self.widget)
        self.outlineLabel.setGeometry(QtCore.QRect(90, 70, 280, 390))
        self.outlineLabel.setStyleSheet("background-color:rgba(0, 0, 0, 100);\n"
"border-radius: 15px;")
        self.outlineLabel.setText("")
        self.outlineLabel.setObjectName("outlineLabel")
        self.titleLabel = QtWidgets.QLabel(self.widget)
        self.titleLabel.setGeometry(QtCore.QRect(100, 70, 251, 51))
        font = QtGui.QFont()
        font.setPointSize(16)
        font.setBold(True)
        font.setWeight(75)
        self.titleLabel.setFont(font)
        self.titleLabel.setStyleSheet("color:rgba(255, 255, 255, 210);")
        self.titleLabel.setObjectName("titleLabel")
        self.userNamelineEdit = QtWidgets.QLineEdit(self.widget)
        self.userNamelineEdit.setGeometry(QtCore.QRect(120, 170, 200, 40))
        font = QtGui.QFont()
        font.setPointSize(10)
        self.userNamelineEdit.setFont(font)
        self.userNamelineEdit.setStyleSheet("background-color:rgba(0, 0, 0, 0);\n"
"border:none;\n"
"border-bottom:2px solid rgba(105, 118, 132, 255);\n"
"color:rgba(255, 255, 255, 230);\n"
"padding-bottom:7px;")
        self.userNamelineEdit.setObjectName("userNamelineEdit")
        self.passwordlineEdit = QtWidgets.QLineEdit(self.widget)
        self.passwordlineEdit.setGeometry(QtCore.QRect(120, 230, 200, 40))
        font = QtGui.QFont()
        font.setPointSize(10)
        self.passwordlineEdit.setFont(font)
        self.passwordlineEdit.setStyleSheet("background-color:rgba(0, 0, 0, 0);\n"
"border:none;\n"
"border-bottom:2px solid rgba(105, 118, 132, 255);\n"
"color:rgba(255, 255, 255, 230);\n"
"padding-bottom:7px;")
        self.passwordlineEdit.setEchoMode(QtWidgets.QLineEdit.Password)
        self.passwordlineEdit.setObjectName("passwordlineEdit")
        self.loginButton = QtWidgets.QPushButton(self.widget)
        self.loginButton.setGeometry(QtCore.QRect(120, 310, 200, 40))
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        self.loginButton.setFont(font)
        self.loginButton.setStyleSheet("QPushButton#loginButton{\n"
"background-color: qlineargradient(spread:pad, x1:0, y1:0.505682, x2:1, y2:0.477, stop:0 rgba(20, 47, 78, 219), stop:1 rgba(85, 98, 112, 226));\n"
"color:rgba(255, 255, 255, 210);\n"
"border-radius:5px;\n"
"}\n"
"QPushButton#loginButton:hover{ \n"
" background-color: qlineargradient(spread:pad, x1:0, y1:0.505682, x2:1, y2:0.477, stop:0 rgba(40, 67, 98, 219), stop:1 rgba(105, 118, 132, 226));\n"
"}\n"
"QPushButton#loginButton:pressed{  \n"
" padding-left:5px;\n"
" padding-top:5px;\n"
"background-color:rgba(105, 118, 132, 200);\n"
"}")
        self.loginButton.setObjectName("loginButton")
        self.newuserLabel = QtWidgets.QLabel(self.widget)
        self.newuserLabel.setGeometry(QtCore.QRect(110, 360, 171, 16))
        font = QtGui.QFont()
        font.setPointSize(8)
        font.setBold(True)
        font.setWeight(75)
        self.newuserLabel.setFont(font)
        self.newuserLabel.setStyleSheet("color: white;")
        self.newuserLabel.setObjectName("newuserLabel")
        self.signupLabel = QtWidgets.QLabel(self.widget)
        self.signupLabel.setGeometry(QtCore.QRect(280, 360, 71, 16))
        font = QtGui.QFont()
        font.setPointSize(8)
        font.setBold(True)
        font.setUnderline(True)
        font.setWeight(75)
        self.signupLabel.setFont(font)
        self.signupLabel.setStyleSheet("color: blue;")
        self.signupLabel.setObjectName("signupLabel")
        self.versionLabel = QtWidgets.QLabel(self.widget)
        self.versionLabel.setGeometry(QtCore.QRect(100, 100, 251, 51))
        font = QtGui.QFont()
        font.setPointSize(10)
        font.setBold(True)
        font.setWeight(75)
        self.versionLabel.setFont(font)
        self.versionLabel.setStyleSheet("color:rgba(255, 255, 255, 210);")
        self.versionLabel.setObjectName("versionLabel")

        self.retranslateUi(loginForm)
        QtCore.QMetaObject.connectSlotsByName(loginForm)

    def retranslateUi(self, loginForm):
        _translate = QtCore.QCoreApplication.translate
        loginForm.setWindowTitle(_translate("loginForm", "Admin Panel LogIn - ShopLens v0.1"))
        self.titleLabel.setText(_translate("loginForm", "ShopLens "))
        self.userNamelineEdit.setPlaceholderText(_translate("loginForm", "Username"))
        self.passwordlineEdit.setPlaceholderText(_translate("loginForm", "Password"))
        self.loginButton.setText(_translate("loginForm", "S i g n  U p"))
        self.newuserLabel.setText(_translate("loginForm", "Already have an account? "))
        self.signupLabel.setText(_translate("loginForm", "Log In"))
        self.versionLabel.setText(_translate("loginForm", "Desktop Client v0.1"))

        self.loginButton.clicked.connect(self.signUp)

if __name__ == "__main__":
        app = QtWidgets.QApplication(sys.argv)
        Form = QtWidgets.QWidget()
        ui = Ui_loginForm()
        ui.setupUi(Form)
        Form.show()
        sys.exit(app.exec_())
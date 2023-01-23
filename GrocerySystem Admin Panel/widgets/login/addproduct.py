# -*- coding: utf-8 -*-


from turtle import update
from PyQt5 import QtCore, QtGui, QtWidgets
from PyQt5.QtWidgets import *
from PyQt5.QtGui import QPixmap
import sys
import random
import sqlite3
from matplotlib import image
import qrcode
import urllib
import pyrebase
import firebase_admin
from firebase_admin import credentials, db


class Ui_AddAProduct(QWidget):


    def setupUi(self, MainWindow):
        MainWindow.setObjectName("MainWindow")
        MainWindow.resize(687, 876)
        MainWindow.setStyleSheet("background-color:rgba(25, 54, 89, 100)")
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        self.label = QtWidgets.QLabel(self.centralwidget)
        self.label.setGeometry(QtCore.QRect(20, 20, 321, 51))
        font = QtGui.QFont()
        font.setPointSize(10)
        font.setBold(True)
        font.setItalic(True)
        font.setWeight(75)
        self.label.setFont(font)
        self.label.setStyleSheet("background-color:rgba(105, 118, 132, 200)")
        self.label.setObjectName("label")
        self.lineEdit = QtWidgets.QLineEdit(self.centralwidget)
        self.lineEdit.setGeometry(QtCore.QRect(30, 130, 501, 31))
        font = QtGui.QFont()
        font.setPointSize(10)
        self.lineEdit.setFont(font)
        self.lineEdit.setStyleSheet("background-color:rgba(105, 118, 132, 200)")
        self.lineEdit.setObjectName("lineEdit")
        self.label_2 = QtWidgets.QLabel(self.centralwidget)
        self.label_2.setGeometry(QtCore.QRect(30, 90, 211, 31))
        font = QtGui.QFont()
        font.setBold(True)
        font.setWeight(75)
        self.label_2.setFont(font)
        self.label_2.setStyleSheet("background-color:rgba(105, 118, 132, 200)")
        self.label_2.setObjectName("label_2")
        self.pushButton = QtWidgets.QPushButton(self.centralwidget)
        self.pushButton.setGeometry(QtCore.QRect(552, 130, 121, 31))
        self.pushButton.setStyleSheet("QPushButton#pushButton{\n"
"background-color:rgba(2, 65, 118, 255);\n"
"color:rgba(255, 255, 255, 200);\n"
"border-radius:5px;\n"
"}\n"
"QPushButton#pushButton:pressed{\n"
"padding-left:5px;\n"
"padding-top:5px;\n"
"background-color:rgba(2, 65, 118, 100);\n"
"background-position:calc(100% - 10px)center;\n"
"}\n"
"QPushButton#pushButton:hover{\n"
"background-color:rgba(2, 65, 118, 200);\n"
"}")
        self.pushButton.setObjectName("pushButton")
        self.label_3 = QtWidgets.QLabel(self.centralwidget)
        self.label_3.setGeometry(QtCore.QRect(30, 170, 291, 151))
        self.label_3.setText("")
        self.label_3.setObjectName("label_3")
        self.label_4 = QtWidgets.QLabel(self.centralwidget)
        self.label_4.setGeometry(QtCore.QRect(30, 350, 191, 31))
        font = QtGui.QFont()
        font.setBold(True)
        font.setWeight(75)
        self.label_4.setFont(font)
        self.label_4.setStyleSheet("background-color:rgba(105, 118, 132, 200)")
        self.label_4.setObjectName("label_4")
        self.lineEdit_2 = QtWidgets.QLineEdit(self.centralwidget)
        self.lineEdit_2.setGeometry(QtCore.QRect(240, 350, 381, 31))
        font = QtGui.QFont()
        font.setPointSize(10)
        self.lineEdit_2.setFont(font)
        self.lineEdit_2.setStyleSheet("background-color:rgba(105, 118, 132, 200)")
        self.lineEdit_2.setObjectName("lineEdit_2")
        self.label_5 = QtWidgets.QLabel(self.centralwidget)
        self.label_5.setGeometry(QtCore.QRect(30, 410, 131, 31))
        font = QtGui.QFont()
        font.setBold(True)
        font.setWeight(75)
        self.label_5.setFont(font)
        self.label_5.setStyleSheet("background-color:rgba(105, 118, 132, 200)")
        self.label_5.setObjectName("label_5")
        self.comboBox = QtWidgets.QComboBox(self.centralwidget)
        self.comboBox.setGeometry(QtCore.QRect(190, 410, 241, 31))
        self.comboBox.setStyleSheet("background-color:rgba(105, 118, 132, 200)")
        self.comboBox.setObjectName("comboBox")
        self.label_6 = QtWidgets.QLabel(self.centralwidget)
        self.label_6.setGeometry(QtCore.QRect(30, 470, 201, 31))
        font = QtGui.QFont()
        font.setBold(True)
        font.setWeight(75)
        self.label_6.setFont(font)
        self.label_6.setStyleSheet("background-color:rgba(105, 118, 132, 200)")
        self.label_6.setObjectName("label_6")
        self.dateEdit = QtWidgets.QDateEdit(self.centralwidget)
        self.dateEdit.setGeometry(QtCore.QRect(260, 470, 171, 31))
        self.dateEdit.setStyleSheet("background-color:rgba(105, 118, 132, 200)")
        self.dateEdit.setObjectName("dateEdit")
        self.label_7 = QtWidgets.QLabel(self.centralwidget)
        self.label_7.setGeometry(QtCore.QRect(30, 530, 101, 31))
        font = QtGui.QFont()
        font.setBold(True)
        font.setWeight(75)
        self.label_7.setFont(font)
        self.label_7.setStyleSheet("background-color:rgba(105, 118, 132, 200)")
        self.label_7.setObjectName("label_7")
        self.comboBox_2 = QtWidgets.QComboBox(self.centralwidget)
        self.comboBox_2.setGeometry(QtCore.QRect(150, 530, 241, 31))
        self.comboBox_2.setStyleSheet("background-color:rgba(105, 118, 132, 200)")
        self.comboBox_2.setObjectName("comboBox_2")
        self.label_8 = QtWidgets.QLabel(self.centralwidget)
        self.label_8.setGeometry(QtCore.QRect(30, 650, 151, 31))
        font = QtGui.QFont()
        font.setBold(True)
        font.setWeight(75)
        self.label_8.setFont(font)
        self.label_8.setStyleSheet("background-color:rgba(105, 118, 132, 200)")
        self.label_8.setObjectName("label_8")
        self.pushButton_2 = QtWidgets.QPushButton(self.centralwidget)
        self.pushButton_2.setGeometry(QtCore.QRect(50, 810, 561, 41))
        self.pushButton_2.setStyleSheet("QPushButton#pushButton_2{\n"
"background-color:rgba(2, 65, 118, 255);\n"
"color:rgba(255, 255, 255, 200);\n"
"border-radius:5px;\n"
"}\n"
"QPushButton#pushButton_2:pressed{\n"
"padding-left:5px;\n"
"padding-top:5px;\n"
"background-color:rgba(2, 65, 118, 100);\n"
"background-position:calc(100% - 10px)center;\n"
"}\n"
"QPushButton#pushButton_2:hover{\n"
"background-color:rgba(2, 65, 118, 200);\n"
"}")
        self.pushButton_2.setObjectName("pushButton_2")
        self.textEdit = QtWidgets.QTextEdit(self.centralwidget)
        self.textEdit.setGeometry(QtCore.QRect(210, 650, 431, 81))
        font = QtGui.QFont()
        font.setPointSize(10)
        self.textEdit.setFont(font)
        self.textEdit.setStyleSheet("background-color:rgba(105, 118, 132, 200)")
        self.textEdit.setObjectName("textEdit")
        self.label_9 = QtWidgets.QLabel(self.centralwidget)
        self.label_9.setGeometry(QtCore.QRect(30, 760, 111, 31))
        font = QtGui.QFont()
        font.setBold(True)
        font.setWeight(75)
        self.label_9.setFont(font)
        self.label_9.setStyleSheet("background-color:rgba(105, 118, 132, 200)")
        self.label_9.setObjectName("label_9")
        self.lineEdit_3 = QtWidgets.QLineEdit(self.centralwidget)
        self.lineEdit_3.setGeometry(QtCore.QRect(160, 760, 381, 31))
        font = QtGui.QFont()
        font.setPointSize(10)
        self.lineEdit_3.setFont(font)
        self.lineEdit_3.setStyleSheet("background-color:rgba(105, 118, 132, 200)")
        self.lineEdit_3.setObjectName("lineEdit_3")
        self.label_10 = QtWidgets.QLabel(self.centralwidget)
        self.label_10.setGeometry(QtCore.QRect(30, 590, 101, 31))
        font = QtGui.QFont()
        font.setBold(True)
        font.setWeight(75)
        self.label_10.setFont(font)
        self.label_10.setStyleSheet("background-color:rgba(105, 118, 132, 200)")
        self.label_10.setObjectName("label_10")
        self.lineEdit_4 = QtWidgets.QLineEdit(self.centralwidget)
        self.lineEdit_4.setGeometry(QtCore.QRect(150, 590, 381, 31))
        font = QtGui.QFont()
        font.setPointSize(10)
        self.lineEdit_4.setFont(font)
        self.lineEdit_4.setStyleSheet("background-color:rgba(105, 118, 132, 200)")
        self.lineEdit_4.setObjectName("lineEdit_4")
        MainWindow.setCentralWidget(self.centralwidget)

        self.productImage = ""

        self.retranslateUi(MainWindow)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    def retranslateUi(self, MainWindow):
        _translate = QtCore.QCoreApplication.translate
        MainWindow.setWindowTitle(_translate("MainWindow", "Add a product"))
        self.label.setText(_translate("MainWindow", "    Add a product Shop Lens v0.1"))
        self.label_2.setText(_translate("MainWindow", "  Add an image of the product:"))
        self.pushButton.setText(_translate("MainWindow", "Browse"))
        self.label_4.setText(_translate("MainWindow", " Enter name of the product:"))
        self.label_5.setText(_translate("MainWindow", " Product Category:"))
        self.label_6.setText(_translate("MainWindow", " Product Manufacturing date:"))
        self.label_7.setText(_translate("MainWindow", " Best before:"))
        self.label_8.setText(_translate("MainWindow", " Product Description:"))
        self.pushButton_2.setText(_translate("MainWindow", "Add Product"))
        self.label_9.setText(_translate("MainWindow", " Stock amout:"))
        self.label_10.setText(_translate("MainWindow", " Price in (Rs.):"))


        self.pushButton.clicked.connect(self.openFileNameDialog)
        self.pushButton_2.clicked.connect(self.addProduct)

        self.comboBox.addItem("Food And Beverage")
        self.comboBox.addItem("Cosmetics And Skin Care")
        self.comboBox.addItem("Hair Care")
        self.comboBox.addItem("Other")

        self.comboBox_2.addItem("2 Weeks")
        self.comboBox_2.addItem("1 Month")
        self.comboBox_2.addItem("6 Months")
        self.comboBox_2.addItem("12 Months")

        currentIndex = self.comboBox.findText("Food And Beverage", QtCore.Qt.MatchFixedString)
        self.comboBox.setCurrentIndex(currentIndex)

        currentIndex2 = self.comboBox.findText("2 Weeks", QtCore.Qt.MatchFixedString)
        self.comboBox.setCurrentIndex(currentIndex2)


    def openFileNameDialog(self):
        fname = QFileDialog.getOpenFileName(self, "Open File", "c:\\gui\\images", "All Files (*);;Python Files (*.py);; PNG Files (*.png)" )
        if fname:
            self.lineEdit.setText(fname[0])
            self.productImage = fname[0]
            qpixmap = QPixmap(fname[0])
            self.label_3.setPixmap(qpixmap)
 
    def addProduct(self):
        fixed_digits = 6
        productID = random.randrange(111111, 999999, fixed_digits)
        print('Product ID: '+ str(productID))
        print(self.productImage)
        #print(self.lineEdit.text())
        print(self.lineEdit_2.text())
        print(self.comboBox.currentText())
        print(str(self.dateEdit.date().day()) + "/" + str(self.dateEdit.date().month()) + "/" + str(self.dateEdit.date().year()))
        print(self.comboBox_2.currentText())
        print(self.lineEdit_4.text())
        print(self.textEdit.toPlainText())
        print(self.lineEdit_3.text())

        qrCodeImage = qrcode.make(str(productID))
        qrCodeImage.save('productQRcodes/'+str(productID)+'_'+self.lineEdit_2.text()+'.jpg')

        # dbConnection = sqlite3.connect('ShopLens.db')
        # cursor = dbConnection.cursor()
        # createTableProduct = """CREATE TABLE IF NOT EXISTS ProductTable (ProductID VARCHAR(255), ProductImage VARCHAR(255), ProductName VARCHAR(255), ProductCategory VARCHAR(255), ProductManufacturingDate VARCHAR(255), ProductExpiry VARCHAR(255), ProductPrice VARCHAR(255), ProductDesc VARCHAR(255), ProductStock VARCHAR(255));"""
        # cursor.execute(createTableProduct)
        # insertData = """INSERT INTO ProductTable VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);"""
        # cursor.execute(insertData, [str(productID), self.lineEdit.text(), self.lineEdit_2.text(), self.comboBox.currentText(), str(self.dateEdit.date().day()) + "/" + str(self.dateEdit.date().month()) + "/" + str(self.dateEdit.date().year()), self.comboBox_2.currentText(), self.lineEdit_4.text(), self.textEdit.toPlainText(), self.lineEdit_3.text()]);
        # dbConnection.commit()
        # cursor.close()
        # dbConnection.close()

        cred = credentials.Certificate("shoplens-27c0d-firebase-adminsdk-74smx-0d0202d4e1.json")
        firebase_admin.initialize_app(cred, {
            "databaseURL" : "https://shoplens-27c0d-default-rtdb.asia-southeast1.firebasedatabase.app"
        })


        firebaseConfig = {'apiKey': "AIzaSyAJryexusJ9oMWKNuNZkQG868Y-DgcZu_k",

                         'authDomain': "shoplens-27c0d.firebaseapp.com",

                         'databaseURL': "https://shoplens-27c0d-default-rtdb.asia-southeast1.firebasedatabase.app",

                        'projectId': "shoplens-27c0d",

                        'storageBucket': "shoplens-27c0d.appspot.com",

                        'messagingSenderId': "419998210483",

                        'appId': "1:419998210483:web:9702bb5a1f65aae405d3c6",

                        'measurementId': "G-QRCN2RM2EP"}

        firebase = pyrebase.initialize_app(firebaseConfig)

        storage=firebase.storage()

        imageFile = self.lineEdit.text()
        storage.child(str(productID)).put(imageFile)

        imageURL = storage.child(str(productID)).get_url(None);

        print(imageURL)

        databaseRefrence = db.reference('/')
        databaseRefrence.child('Products').child(str(productID)).set({


                    'ProductName': self.lineEdit_2.text(),
                    'ProductImageURL' : imageURL,
                    'ProductCategory' : self.comboBox.currentText(),
                    'ProductManufacturingDate' : str(self.dateEdit.date().day()) + "/" + str(self.dateEdit.date().month()) + "/" + str(self.dateEdit.date().year()),
                    'ProductExpiry' : self.comboBox_2.currentText(),
                    'ProductPrice' : self.lineEdit_4.text(),
                    'ProductDesc' : self.textEdit.toPlainText(),
                    'ProductStock' : self.lineEdit_3.text()

        
        })

        self.messageBox("Successfully added a product", "QR code generated at /productQRcodes")

    def messageBox(self, title, message):
        messageBoxWidget = QMessageBox()
        messageBoxWidget.setWindowTitle(title)
        messageBoxWidget.setIcon(QMessageBox.Information)
        messageBoxWidget.setText(message)
        messageBoxWidget.setStandardButtons(QMessageBox.Ok)
        messageBoxWidget.exec_()



if __name__ == "__main__":
    app = QtWidgets.QApplication(sys.argv)
    MainWindow = QtWidgets.QMainWindow()
    ui = Ui_AddAProduct()
    ui.setupUi(MainWindow)
    MainWindow.show()
    sys.exit(app.exec_())

# -*- coding: utf-8 -*-



from PyQt5 import QtCore, QtGui, QtWidgets
from addproduct import Ui_AddAProduct
import matplotlib.pyplot as plt


class Ui_AdminPanel(object):
    def setupUi(self, MainWindow):
        MainWindow.setObjectName("MainWindow")
        MainWindow.resize(811, 488)
        font = QtGui.QFont()
        font.setPointSize(10)
        MainWindow.setFont(font)
        MainWindow.setStyleSheet("background-color:rgba(25, 54, 89, 100);")
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        self.label = QtWidgets.QLabel(self.centralwidget)
        self.label.setGeometry(QtCore.QRect(10, 20, 391, 41))
        font = QtGui.QFont()
        font.setPointSize(10)
        font.setBold(True)
        font.setItalic(True)
        font.setWeight(75)
        self.label.setFont(font)
        self.label.setStyleSheet("background-color:rgba(105, 118, 132, 200)")
        self.label.setObjectName("label")
        self.pushButton = QtWidgets.QPushButton(self.centralwidget)
        self.pushButton.setGeometry(QtCore.QRect(120, 110, 541, 51))
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
        self.pushButton_2 = QtWidgets.QPushButton(self.centralwidget)
        self.pushButton_2.setGeometry(QtCore.QRect(120, 260, 541, 51))
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
        self.pushButton_3 = QtWidgets.QPushButton(self.centralwidget)
        self.pushButton_3.setGeometry(QtCore.QRect(120, 340, 541, 51))
        self.pushButton_3.setStyleSheet("QPushButton#pushButton_3{\n"
"background-color:rgba(2, 65, 118, 255);\n"
"color:rgba(255, 255, 255, 200);\n"
"border-radius:5px;\n"
"}\n"
"QPushButton#pushButton_3:pressed{\n"
"padding-left:5px;\n"
"padding-top:5px;\n"
"background-color:rgba(2, 65, 118, 100);\n"
"background-position:calc(100% - 10px)center;\n"
"}\n"
"QPushButton#pushButton_3:hover{\n"
"background-color:rgba(2, 65, 118, 200);\n"
"}")
        self.pushButton_3.setObjectName("pushButton_3")
        self.pushButton_4 = QtWidgets.QPushButton(self.centralwidget)
        self.pushButton_4.setGeometry(QtCore.QRect(120, 180, 541, 51))
        self.pushButton_4.setStyleSheet("QPushButton#pushButton_4{\n"
"background-color:rgba(2, 65, 118, 255);\n"
"color:rgba(255, 255, 255, 200);\n"
"border-radius:5px;\n"
"}\n"
"QPushButton#pushButton_4:pressed{\n"
"padding-left:5px;\n"
"padding-top:5px;\n"
"background-color:rgba(2, 65, 118, 100);\n"
"background-position:calc(100% - 10px)center;\n"
"}\n"
"QPushButton#pushButton_4:hover{\n"
"background-color:rgba(2, 65, 118, 200);\n"
"}")
        self.pushButton_4.setObjectName("pushButton_4")
        self.pushButton_5 = QtWidgets.QPushButton(self.centralwidget)
        self.pushButton_5.setGeometry(QtCore.QRect(680, 20, 121, 41))
        self.pushButton_5.setStyleSheet("QPushButton#pushButton_5{\n"
"background-color:rgba(2, 65, 118, 255);\n"
"color:rgba(255, 255, 255, 200);\n"
"border-radius:5px;\n"
"}\n"
"QPushButton#pushButton_5:pressed{\n"
"padding-left:5px;\n"
"padding-top:5px;\n"
"background-color:rgba(2, 65, 118, 100);\n"
"background-position:calc(100% - 10px)center;\n"
"}\n"
"QPushButton#pushButton_5:hover{\n"
"background-color:rgba(2, 65, 118, 200);\n"
"}")
        self.pushButton_5.setObjectName("pushButton_5")
        MainWindow.setCentralWidget(self.centralwidget)

        self.retranslateUi(MainWindow)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    def retranslateUi(self, MainWindow):
        _translate = QtCore.QCoreApplication.translate
        MainWindow.setWindowTitle(_translate("MainWindow", "Admin Panel "))
        self.label.setText(_translate("MainWindow", "Welcome!  Shop Lens v0.1 Admin Operations :"))
        self.pushButton.setText(_translate("MainWindow", "Add Products"))
        self.pushButton_2.setText(_translate("MainWindow", "Sales Analytics"))
        self.pushButton_3.setText(_translate("MainWindow", "Payment Logs"))
        self.pushButton_4.setText(_translate("MainWindow", "Check Stock"))
        self.pushButton_5.setText(_translate("MainWindow", "Log Out"))


        self.pushButton.clicked.connect(self.redirectToAddAProduct)
        self.pushButton_2.clicked.connect(self.redirectToAnalytics)
        self.pushButton_4.clicked.connect(self.redirectToStocks)

    def redirectToAddAProduct(self):
        self.window = QtWidgets.QMainWindow()
        self.ui = Ui_AddAProduct()
        self.ui.setupUi(self.window)

    def redirectToAnalytics(self):
        x = ["Food And Beverage", "Cosmetics And Skin Care", "Hair Care" , "Other"]
        h = [200, 300, 500, 700]
        plt.bar(x, h)
        plt.xlabel("Product Category")
        plt.ylabel("Revenue")
        plt.title("Sales Analytics")
        plt.show()
    
    def redirectToStocks(self):
        x = ["Food And Beverage", "Cosmetics And Skin Care", "Hair Care" , "Other"]
        h = [20, 10, 50, 40]
        plt.bar(x, h)
        plt.xlabel("Inventory")
        plt.ylabel("Stock")
        plt.title("Inventory Management")
        plt.show()



        




if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    MainWindow = QtWidgets.QMainWindow()
    ui = Ui_AdminPanel()
    ui.setupUi(MainWindow)
    MainWindow.show()
    sys.exit(app.exec_())

import serial
import time
ser = serial.Serial('COM3',9600)
b = 0
print('Processing your request.')
while True:
    file = open('abc.txt')
    a = file.read().strip()
    b+=1
    file.close()
    ser.write(a.encode())
    time.sleep(1)
    if b==15:
        file = open("abc.txt","w")
        file.write("0")
        file.close()
        if a=='1':
            print("Success")
        else:
            print("Failed")
        time.sleep(2)
        break
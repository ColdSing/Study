#ssi.py
#-*-coding:utf-8-*-

import turtle
import time
LENTH =120
GAP=20
X=-550
Y=100

def main():
	turtle.setup(1300,800,0,0)
	p= turtle.Turtle()
	p.color("green")
	p.pensize(10)
	p.hideturtle()
	p.speed(0)
	while True:
		x,y=X,Y
		initial(p)
		Data = time.strftime("%H%M%S")
		for i in range(len(Data)):
			SSI(int(Data[i]),p)
			x=x+LENTH+GAP
			p.penup()
			p.goto(x,y)
			p.pendown()

def initial(pen):
	pen.clear()
	pen.penup()
	pen.goto(X,Y)
	pen.pendown()
	pen.setheading(0) 
	
def SSI(num,pen):
	CList=[]
	if num==0:
		CList=['a','b','c','d','e','f']
	elif num==1:
		CList= ['b','c']
	elif num==2:
		CList=['a','b','g','e','d']
	elif num==3:
		CList=['a','b','g','c','d']
	elif num==4:
		CList=['f','g','b','c']
	elif num==5:
		CList=['a','f','g','c','d']	
	elif num==6:
		CList=['a','f','g','c','d','e']
	elif num==7:
		CList=['a','b','c']
	elif num==8:
		CList=['a','b','c','d','e','f','g']
	elif num==9:
		CList=['a','b','c','d','f','g']
	else:
		print("Error")
	for i in CList:
		cloum(i,pen)


def cloum(c,pen):
	x=pen.xcor()
	y=pen.ycor()
	if c=='a':
		PenMove(10,-5,pen)
		pen.fd(100)
	elif c=='b':
		PenMove(115,-10,pen)
		pen.right(90)
		pen.fd(100)
	elif c=='c':
		PenMove(115,-120,pen)
		pen.right(90)
		pen.fd(100)
	elif c=='d':
		PenMove(10,-225,pen)
		pen.fd(100)
	elif c=='e':
		PenMove(5,-120,pen)
		pen.right(90)
		pen.fd(100)
	elif c=='f':
		PenMove(5,-10,pen)
		pen.right(90)
		pen.fd(100)
	elif c=='g':
		PenMove(10,-115,pen)
		pen.fd(100)
	else:
		print("Error")
	pen.penup()
	pen.goto(x,y)
	pen.pendown()
	pen.setheading(0) 
	
def PenMove(x,y,pen):
	pen.penup()
	pen.goto(pen.xcor()+x,pen.ycor()+y)
	pen.pendown()
	
main()

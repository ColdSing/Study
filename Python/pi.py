#pi.py
from random import random
from math import sqrt
from time import clock
DOTS = int(input("输入整数"))
hits = 0
clock()
for i in range(1,DOTS):
	x,y = random(),random()
	dist = sqrt(x**2 + y**2)
	if dist <=1.0:
		hits = hits+1
pi = 4*(hits/DOTS)
print("Pi=%s"%pi)
print("time = %-5.5ss"%clock())
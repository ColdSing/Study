#bmi.py

def main():
	while True:
		try:
			Height = float(input("输入你的身高（以米为单位仅输入数字如1.75）："))
			Weight = float(input("输入你的体重（以公斤为单位仅输入数字如75）："))
			BMI = Weight/(Height**2)
			break
		except:
			print("体重身高输入错误！")
	if BMI<18.5:
		BmiClass = "偏瘦"
	elif BMI>=18.5 and BMI<25:
		BmiClass = "正常"
	elif BMI>=25 and BMI<30:
		BmiClass = "偏胖"
	else:
		BmiClass = "肥胖"
	print("你的BMI指数为{0:.2f}，体重{1}".format(BMI,BmiClass))

main()
		
import turtle


def wordcount(line,worddic):
    line = line.lower()
    for ch in line:
        if ch in "!"#$%&'()*+,-./0123456789:;<=>?@[\]^_`{|}~"

def main():
    filename = input("Enter a file name:").strip()
    inflie = open(filename,'r')
    
    lines = inflie.readlines()



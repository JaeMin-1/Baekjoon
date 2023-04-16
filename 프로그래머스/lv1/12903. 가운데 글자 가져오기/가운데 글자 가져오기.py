def solution(s):
    lower = 0
    upper = len(s)-1
    middle = (lower + upper) / 2
    if upper % 2 != 0:
        return s[(len(s)-1)//2:(len(s)-1)//2+1+1]
    return s[(len(s)-1)//2]
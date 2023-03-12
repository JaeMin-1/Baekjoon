import sys
K = int(input())
stack = []
for i in range(K):
    num = int(sys.stdin.readline())
    if num == 0:
        del stack[-1]
    else:
        stack.append(num)
print(sum(stack))
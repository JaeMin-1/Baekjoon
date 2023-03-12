import sys
N = int(input())
for i in range(N):
    PS = sys.stdin.readline()
    cnt = [0,0]
    for i in PS:
        if i == '(':
            cnt[0] += 1
        elif i == ')':
            cnt[1] += 1

        if cnt[0] < cnt[1]:
            print('NO')
            break

        if i == PS[-1]:
            if cnt[0] == cnt[1]:
                print('YES')
            else:
                print('NO')

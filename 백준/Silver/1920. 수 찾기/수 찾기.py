# N과 M이 1부터 10만 사이로 주어지기 때문에 단순 for문 비교는 시간초과에 걸린다.
# 따라서 이진탐색을 사용한다.

def binary_search(num, list, start, end):
    if start>end:
        return 0
    mid = (start+end)//2
    if num == list[mid]:
        return 1
    elif num > list[mid]:
        return binary_search(num, list, mid+1, end)
    elif num < list[mid]:
        return binary_search(num, list, start, mid-1)

N = int(input())
A_numbers = sorted(list(map(int, input().split())))
N = int(input())
numbers = list(map(int, input().split()))

for i in numbers:
    start = 0
    end = len(A_numbers)-1
    print(binary_search(i, A_numbers, start, end))
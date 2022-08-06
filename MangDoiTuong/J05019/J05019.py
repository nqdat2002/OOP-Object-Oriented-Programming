dic = {}

n = int(input())

for i in range(n):
    name = input()
    start = input().split(':')
    st = int(start[0]) * 60 + int(start[1])

    end = input().split(':')
    ed = int(end[0]) * 60 + int(end[1])
    mua = int(input())
    try:
        (dic[name])[0] += ed - st
        (dic[name])[1] += mua
    except:
        dic.update({name : [0, 0]})
        (dic[name])[0] += ed - st
        (dic[name])[1] += mua

dem = 0
for key, value in dic.items():
    dem += 1
    print('T{:02d}'.format(dem), key, '{:.2f}'.format(value[1]*60/ value[0]))

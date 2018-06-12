# -*- coding: utf-8 -*-
import pulp
import sys

def main(cons):
    conl = cons.split("|")
    V_NUM = len(conl)
    #变量，直接设置下限
    variables = [pulp.LpVariable('X%06d'%i , lowBound = 0.0, upBound = 1.0,cat = pulp.LpContinuous) for i in range(0 , V_NUM)]
    #目标函数
    objective = sum([variables[i] for i in range(0 , V_NUM)])
    #约束条件
    constraints = []
    for i in range(0, V_NUM):
        aList = []
        aList = conl[i].split(',')
        alen = len(aList)
        constraints.append(sum([variables[int(aList[j])] for j in range(0 , alen)]) >=1.0)
	
	#求解线性规划问题
	prob = pulp.LpProblem('LP' , pulp.LpMinimize)
    prob += objective
    for cons in constraints :
        prob += cons
    status = prob.solve()#判断是否有解
    if status != 1 :
        return None
    else :
        var = prob.variables()
        
    res = [var[i].varValue.real for i in range(0,len(var))]
    print res
if __name__ == '__main__':
	#print 1
    strList = raw_input()
	#print 2
    main(strList)

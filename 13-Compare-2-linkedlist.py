#!/bin/python3

import math
import os
import random
import re
import sys

class SinglyLinkedListNode:
    def __init__(self, node_data):
        self.data = node_data
        self.next = None

class SinglyLinkedList:
    def __init__(self):
        self.head = None

    def traverse(self):
        temp = self.head
        while(temp):
            print(temp.data)
            temp = temp.next

# def print_singly_linked_list(node, sep, fptr):
#     while node:
#         fptr.write(str(node.data))

#         node = node.next

#         if node:
#             fptr.write(sep)
# Complete the insertNodeAtTail function below.

#
# For your reference:
#
# SinglyLinkedListNode:
#     int data
#     SinglyLinkedListNode next

# printing the linked list in reverse order

def compare_lists(llist1, llist2):
    isequal =  1

    while llist1 != None or llist2 != None:
        if llist1 == None:
            isequal = 0
            break
        
        if llist1 == None:
            isequal = 0
            break
        
        if llist1.data != llist2.data:
            isequal = 0
            break
        llist1 = llist1.next
        llist2 = llist2.next
    
    return isequal
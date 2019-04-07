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

def insertNodeAtPosition(head, data, position):
    if position == 0:
        p = head
        head = SinglyLinkedListNode(data)
        head.next = p
        return head
    p = head
    while position-1 > 0:
        p = p.next
        position = position-1
    
    temp = p.next
    new_node = SinglyLinkedListNode(data)
    new_node.next = temp
    p.next = new_node
    return head

    # if head == None:
    #     head = SinglyLinkedListNode(data)
    #     return head
    # else:
    #     p = head
    #     head = SinglyLinkedListNode(data)
    #     head.next = p
    #     return head
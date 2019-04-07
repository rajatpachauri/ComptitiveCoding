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

def reversePrint(head):
    if head.next:
        reversePrint(head.next)
    print(head.data)

# reversing the linked list

def reverse(head):
    if head == None or head.next == None:
        return head

    remaining = reverse(head.next)
    
    head.next.next = head
    head.next = None
    
    return remaining
    

    

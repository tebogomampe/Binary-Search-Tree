#  Student Record Binary Search Tree (BST)

A Java implementation of a **Binary Search Tree (BST)** designed to manage university student records. This project was built as part of an assignment to demonstrate core data structure concepts including insertion, searching, deletion, traversal, and tree analysis.

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [BST Rules](#-bst-rules)
- [Project Structure](#-project-structure)
- [Class Descriptions](#-class-descriptions)
- [Deletion Cases](#-deletion-cases)
- [How to Compile and Run](#-how-to-compile-and-run)
- [Sample Output](#-sample-output)
- [Time Complexity](#-time-complexity)
- [Technologies Used](#-technologies-used)
- [Author](#-author)
- [License](#-license)

---

## Overview

A university department needs a simple system for storing and retrieving student records. Each student has:

- **Student Number** (used as the BST key)
- **Name**
- **Programme**
- **Average Mark**

When a new student is added, the student number is compared with the current node:
- If the new number is **smaller** → move to the **left subtree**
- If the new number is **larger** → move to the **right subtree**
- **Duplicates are rejected**

This project implements the BST from scratch **without** using Java's `TreeSet`, `TreeMap`, or any built-in tree collection.

---

## Features

| Feature | Description |
|---|---|
| **Insert** | Adds a new student while preserving the BST property |
| **Search** | Finds a student by number and traces the path visited |
| **Delete** | Removes a student handling all 3 standard BST cases |
| **In-order Traversal** | Displays records in ascending student-number order |
| **Pre-order Traversal** | Node → Left → Right |
| **Post-order Traversal** | Left → Right → Node |
| **Find Minimum** | Returns the student with the smallest number |
| **Find Maximum** | Returns the student with the largest number |
| **Count Nodes** | Returns the total number of students |
| **Height** | Returns the height of the tree |

---

## BST Rules

Every node in the tree must satisfy:

1.  Stores exactly **one** student record
2.  The **student number** is the key used for ordering
3.  All keys in the **left subtree** are **smaller** than the current node's key
4.  All keys in the **right subtree** are **larger** than the current node's key
5.  **Duplicate** student numbers are **not allowed**
6.  No use of `TreeSet`, `TreeMap`, or other built-in tree implementations

---

## Project Structure


---

## Class Descriptions

### `StudentNode.java`

Represents a single node in the BST.

| Field | Type | Description |
|---|---|---|
| `studentNumber` | `int` | Unique student number (BST key) |
| `name` | `String` | Student's full name |
| `programme` | `String` | Programme of study |
| `averageMark` | `double` | Average mark |
| `left` | `StudentNode` | Reference to left child |
| `right` | `StudentNode` | Reference to right child |

### `StudentBST.java`

Implements the Binary Search Tree with the following public methods:

```java
boolean insert(StudentNode student)
StudentNode search(int studentNumber)
boolean delete(int studentNumber)
void inOrder()
void preOrder()
void postOrder()
StudentNode findMinimum()
StudentNode findMaximum()
int countNodes()
int height()

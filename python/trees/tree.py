#!/usr/bin/env python3

class TreeNode:

	# constructor
	def __init__(self, val):
		self.val = val
		self.left = None
		self.right = None

	# insert
	def insert(self, val):

		# handle case where initialization was without a root node
		if self.val is None:
			self.val = val

		else:
			if val < self.val:
				if self.left is None:
					self.left = TreeNode(val)
				else:
					self.left.insert(val)

			elif val >= self.val:
				if self.right is None:
					self.right = TreeNode(val)
				else:
					self.right.insert(val)


	def printTreePreorder(self):
		print(self.val)
		if self.left is not None:
			self.left.printTreePreorder()
		if self.right is not None:
			self.right.printTreePreorder()

	def printTreeInorder(self):
		if self.left is not None:
			self.left.printTreeInorder()
		print(self.val)
		if self.right is not None:
			self.right.printTreeInorder()	

	def printTreePostorder(self):
		if self.left is not None:
			self.left.printTreePostorder()
		if self.right is not None:
			self.right.printTreePostorder()	
		print(self.val)


if __name__=="__main__":
	rootNode = TreeNode(1)
	rootNode.insert(2)
	rootNode.insert(3)
	rootNode.insert(4)
	rootNode.insert(5)

	print("Preorder")
	rootNode.printTreePreorder()

	print("Inorder")
	rootNode.printTreeInorder()

	print("Postorder")
	rootNode.printTreePostorder()

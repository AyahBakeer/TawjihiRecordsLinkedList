package application;

public class LL {
	Nodee head;
	int size = 0;

	public Nodee getHead() {
		return head;
	}

	public void add(int seatnumber, String branch, double average) {
		Nodee newNode = new Nodee(seatnumber, branch, average);
		if (head == null) {
			head = newNode;
		} else {
			size++;
		}
	}

	public void addFirst(int seatnumber, String branch, double average) {
		Nodee newNode = new Nodee(seatnumber, branch, average);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	public void addLast(int seatnumber, String branch, double average) {
		Nodee newNode = new Nodee(seatnumber, branch, average);
		if (head == null) {
			head = newNode;
		} else {
			size++;
		}
	}

	// method to retun double mean of all students
	public double mean() {
		double sum = 0;
		int count = 0;

		Nodee temp = head;
		while (temp != null) {

			sum += temp.getAverage();
			count++;
			temp = temp.next;
		}
		System.out.println("sum = " + sum);
		System.out.println("count = " + count);
		return sum / count;
	}

	// method to return the number and percentage of students above or equal to a
	// certain grade
	public String above(double grade, String br) {
			double count = 0;
			Nodee temp = head;
			double size = 0;
			 while(temp != null){
				 if(temp.getBranch().equals(br)){
		            size++;
				 }
		            temp = temp.next;
		        }
		        Nodee temp2 = head;
		        while(temp2 != null){
		            if(temp2.getAverage() >= grade && temp2.getBranch().equals(br)){
		                count++;
		            }
		            temp2 = temp2.next;
		        }


			return "Number of students above " + grade + "\n"+ " is " + (int) count + "\n" + " and the percentage is "
					+ (count / size) * 100 + "%" ;

	}

	// method to return the mode average of all students
	public double mode() {
		double mode = 0;
		int count = 0;
		int maxCount = 0;
		Nodee temp = head;
		while (temp != null) {

			Nodee temp2 = head;
			while (temp2 != null) {

				if (temp.getAverage() == temp2.getAverage()) {
					count++;
				}
				temp2 = temp2.next;
			}
			if (count > maxCount) {
				maxCount = count;
				mode = temp.getAverage();
			}
			count = 0;
			temp = temp.next;
		}
		return mode;
	}

	public void insertSorted(int seatnumber, String branch, double average) {
		Nodee current = head;
		Nodee newNode = new Nodee(seatnumber, branch, average);
		if (head == null) {
			head = newNode;
		} else {
			while (current.next != null) {
				if (current.getAverage() > current.next.getAverage()) {
					newNode = current.next;
					current.next = newNode.next;
					newNode.next = current;
				}
				current = current.next;
			}
		}
	}

	// return top 10 nodes
	public LL topTen(String Branch) {
		LL topTen = new LL();
		Nodee current = head;
		if (head == null) {
			System.out.println("list is empty");
		} else {
			for (int i = 0; i < 10; i++) {
				if (!current.getBranch().equals(Branch)) {
					current = current.next;
					i--;
					continue;
				}
				Nodee newNode = new Nodee(current.getSeatnumber(), current.getBranch(), current.getAverage());
				topTen.insert(newNode);
				current = current.next;
			}
		}
		return topTen;
	}

	public void insert(Nodee newlyInserted) {
		if (this.head == null) {
			this.head = newlyInserted;
		} else {
			Nodee current = this.head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newlyInserted;
		}
	}

	public void sort() {
		Nodee current = head;
		Nodee index = null;
		int temp;
		double doubletemp;
		String stringtemp;
		if (head == null) {
			return;
		} else {
			while (current != null) {
				index = current.next;
				while (index != null) {
					if (current.getAverage() < index.getAverage()) {
						temp = current.getSeatnumber();
						current.setSeatnumber(index.getSeatnumber());
						index.setSeatnumber(temp);
						doubletemp = current.getAverage();
						current.setAverage(index.getAverage());
						index.setAverage(doubletemp);
						//
						stringtemp = current.getBranch();
						current.setBranch(index.getBranch());
						index.setBranch(stringtemp);

					}
					index = index.next;
				}
				current = current.next;
			}
		}
	}

	public void add(int index, int seatnumber, String branch, double average) {
		Nodee newNode = new Nodee(seatnumber, branch, average);
		if (index == 0) {
			addFirst(seatnumber, branch, average);
		} else if (index == size) {
			addLast(seatnumber, branch, average);
		} else {
			Nodee current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
			size++;
		}
	}

	public void removeFirst() {
		if (head == null) {
			System.out.println("List is empty");
		} else {
			head = head.next;
			size--;
		}
	}

	public void removeLast() {
		if (head == null) {
			System.out.println("List is empty");
		} else {
			Nodee current = head;
			for (int i = 0; i < size - 2; i++) {
				current = current.next;
			}
			current.next = null;
			size--;
		}
	}

	public void delete(int seatNumber) {
		Nodee current = head;
		Nodee previous = null;
		if (head == null) {
			System.out.println("List is empty");
		} else {
			while (current != null) {
				if (current.getSeatnumber() == seatNumber) {
					if (previous == null) {
						head = current.next;
					} else {
						previous.next = current.next;
					}
					size--;
					break;
				}
				previous = current;
				current = current.next;
			}
		}
	}

	public Nodee search(int seatnumber) {
		Nodee ptr1 = head;
		Nodee current = ptr1;
		while (ptr1 != null) {
			if (seatnumber == ptr1.getSeatnumber()) {
				return ptr1;
			} else {
				ptr1 = ptr1.next;
			}
		}
		return null;
	}
}

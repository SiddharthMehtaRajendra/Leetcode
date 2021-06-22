// Self Solved

package Easy;

public class DesignParkingSystem {
	class ParkingSystem {
		int[] parkingLot = new int[3];

		public ParkingSystem(int big, int medium, int small) {
			this.parkingLot[0] = big;
			this.parkingLot[1] = medium;
			this.parkingLot[2] = small;
		}

		public boolean addCar(int carType) {
			if (this.parkingLot[carType - 1]-- > 0)
				return true;
			return false;
		}
	}
}

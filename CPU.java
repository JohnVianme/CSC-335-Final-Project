import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;

public class CPU extends Player {

	private final CpuMode mode;

	/*
	 * CPU constructer same as player but has a mode
	 */
	public CPU(String name, CpuMode mode) {
		super(name);
		this.mode = mode;
	}

	/*
	 * Method for getting the cpu mode
	 */
	public CpuMode getCpuMode() {
		return mode;
	}

	/*
	 * This the best Category for the cpu to fill, will be used by super submit hand
	 * 
	 * @pre rollCount != 3
	 * 
	 * @post best Category will be sumbited
	 */
	public Category getBestCategory() {
		assert this.getRollCount() != 3;
		
		
		return null;
	}

	/*
	 * This returns the first Category for the cpu to fill, will be used by super
	 * submit hand
	 * 
	 * @pre rollCount != 3
	 * 
	 * @post first Category will be sumbited
	 */
	public Category getFirstCategory() {
		assert this.getRollCount() != 3;

		
		return this.getUnfilledCategories().get(0);
	}

}

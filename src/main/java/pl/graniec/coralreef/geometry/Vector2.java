/**
 * Copyright (c) 2009, Coral Reef Project
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *  * Neither the name of the Coral Reef Project nor the names of its
 *    contributors may be used to endorse or promote products derived from this
 *    software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package pl.graniec.coralreef.geometry;

/**
 * @author Piotr Korzuszek <piotr.korzuszek@gmail.com>
 *
 */
public class Vector2 {
	/**
	 * Calculates angle of given vector <code>x</code> and <code>y</code>
	 * components. The value is calculated from positive X axis and increasing
	 * counter clockwise.
	 * 
	 * @param x The x component
	 * @param y The y component
	 * 
	 * @return Angle value in degrees from -180 to 180.
	 */
	public static final float angle(final float x, final float y) {
		
		final float[] n = normalize(x, y); 
		
		final float acos = (float) Math.toDegrees(Math.acos(n[0]));
		final float asin = (float) Math.toDegrees(Math.asin(n[1]));
		
		return (asin >= 0 ? acos : -acos);
	}

	public static final float length(final float x, final float y) {
		return (float) StrictMath.sqrt(x * x + y * y);
	}
	
	
	/**
	 * Normalizes the vector components <code>x</code> and
	 * <code>y</code> to length of 1. Result is returned as float
	 * array where 0 index is new x component and 1 is new y component.
	 * 
	 * @param x The x component
	 * @param y The y component
	 * 
	 * @return Normalized vector x and y components.
	 */
	private static final float[] normalize(final float x, final float y) {
		final float[] result = new float[2];
		final float length = length(x, y);
		
		result[0] = x / length;
		result[1] = y / length;
		
		return result;
	}
	
	public float x, y;
	
	public Vector2(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Calculates angle of given vector.
	 * The value is calculated from positive X axis and increasing
	 * counter clockwise.
	 * 
	 * 
	 * @return Angle value in degrees from -180 to 180.
	 */
	public final float angle() {
		return angle(x, y);
	}
}
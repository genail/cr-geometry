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
 * Angle class represents an Angle value and allows to
 * make several angle calculations.
 * <p>
 * Keep in mind that initial Angle value is stored
 * in degrees so using degree calculations are slightly
 * faster than radian calculations.
 * 
 * @author Piotr Korzuszek <piotr.korzuszek@gmail.com>
 *
 */
public class Angle {
	
	/**
	 * @return The angle value in degrees.
	 */
	public static float degreesValue(float radians) {
		return radians * 180f / (float) Math.PI;
	}
	
	/**
	 * Creates new Angle from <code>degrees</code> value.
	 * 
	 * @param degrees Angle value in degrees (can be positive or negative).
	 * 
	 * @return New Angle object.
	 */
	public static Angle fromDegrees(float degrees) {
		return new Angle(degrees);
	}
	
	/**
	 * Creates new Angle from <code>radians</code> value.
	 * 
	 * @param radians Angle value in radians (can be positive or negative).
	 * 
	 * @return New Angle object.
	 */
	public static Angle fromRadians(float radians) {
		return new Angle(Angle.degreesValue(radians));
	}
	
	/**
	 * @return The angle value in radians.
	 */
	public static float radiansValue(float degrees) {
		return degrees * (float)Math.PI / 180.0f;
	}
	
	/** Angle value in degrees */
	private float degrees;

	public Angle(Angle other) {
		this.degrees = other.degrees;
	}
	
	protected Angle(float degrees) {
		this.degrees = degrees;
	}
	
	/**
	 * Computes the value difference between two angles.
	 * <p>
	 * The difference is given in value between
	 * <code>-180</code> and <code>180</code>. This is the
	 * closest to 0 value that you have to add to this
	 * angle to reach the value of <code>other</code> angle.
	 * 
	 * @param other The other Angle object.
	 * 
	 * @return Difference between two angles.
	 */
	public float degreeDifference(Angle other) {
		final Angle norm1 = new Angle(this);
		final Angle norm2 = new Angle(other);
		
		norm1.normalize();
		norm2.normalize();
		
		final float value = norm2.degrees - norm1.degrees;
		
		if (Math.abs(value) <= 180f) {
			return value;
		} else {
			return value > 0 ? -360f + value : 360 + value;
		}
	}
	
	/**
	 * @return The angle value in degrees.
	 */
	public float degreesValue() {
		return degrees;
	}
	
	/**
	 * Normalizes the angle value that it describes only
	 * one spin and its value is positive >= 0 and < 360 in
	 * degrees.
	 * <p>
	 * This method will change the object initial value.
	 * 
	 * @return Instance to <code>this</code> object.
	 */
	public Angle normalize() {
		degrees %= 360;
		
		if (degrees < 0) {
			degrees += 360;
		}
		
		return this;
	}

	/**
	 * Works like {@link #degreeDifference(Angle)} but in radians.
	 * 
	 * @param other Other angle.
	 * 
	 * @return Radians difference.
	 */
	public float radiansDifference(Angle other) {
		 return Angle.radiansValue(degreeDifference(other));
	}
	
	/**
	 * @return The angle value in radians.
	 */
	public float radiansValue() {
		return Angle.radiansValue(degrees);
	}
}

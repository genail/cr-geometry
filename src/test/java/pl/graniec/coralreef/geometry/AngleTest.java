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

import junit.framework.TestCase;

/**
 * @author Piotr Korzuszek <piotr.korzuszek@gmail.com>
 *
 */
public class AngleTest extends TestCase {

	/**
	 * Test method for {@link pl.graniec.coralreef.geometry.Angle#degreesValue()}.
	 */
	public void testDegreesValue() {
		assertEquals(90, Angle.fromDegrees(90).degreesValue(), 0.01);
		assertEquals(-90, Angle.fromDegrees(-90).degreesValue(), 0.01);
		assertEquals(990, Angle.fromDegrees(990).degreesValue(), 0.01);
		assertEquals(-990, Angle.fromDegrees(-990).degreesValue(), 0.01);
	}

	/**
	 * Test method for {@link pl.graniec.coralreef.geometry.Angle#normalize()}.
	 */
	public void testNormalize() {
		assertEquals(0, Angle.fromDegrees(0).normalize().degreesValue(), 0.01);
		assertEquals(1, Angle.fromDegrees(361).normalize().degreesValue(), 0.01);
		assertEquals(359, Angle.fromDegrees(-1).normalize().degreesValue(), 0.01);
		assertEquals(359, Angle.fromDegrees(-361).normalize().degreesValue(), 0.01);
	}

	/**
	 * Test method for {@link pl.graniec.coralreef.geometry.Angle#radiansValue()}.
	 */
	public void testRadiansValue() {
		assertEquals(Math.toRadians(90), Angle.fromDegrees(90).radiansValue(), 0.01);
		assertEquals(Math.toRadians(-90), Angle.fromDegrees(-90).radiansValue(), 0.01);
		assertEquals(Math.toRadians(990), Angle.fromDegrees(990).radiansValue(), 0.01);
		assertEquals(Math.toRadians(-990), Angle.fromDegrees(-990).radiansValue(), 0.01);
	}
	
	public void testDegreeDifference() {
		Angle a1, a2;
		
		a1 = Angle.fromDegrees(10);
		a2 = Angle.fromDegrees(20);
		
		assertEquals(10, a1.degreeDifference(a2), 0.01);
		
		
		a1 = Angle.fromDegrees(20);
		a2 = Angle.fromDegrees(10);
		
		assertEquals(-10, a1.degreeDifference(a2), 0.01);
		
		
		a1 = Angle.fromDegrees(10);
		a2 = Angle.fromDegrees(350);
		
		assertEquals(-20, a1.degreeDifference(a2), 0.01);
		
		
		a1 = Angle.fromDegrees(350);
		a2 = Angle.fromDegrees(10);
		
		assertEquals(20, a1.degreeDifference(a2), 0.01);
	}
}

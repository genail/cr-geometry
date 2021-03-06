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
public class Vector2Test extends TestCase {

	public void setUp() throws Exception {
	}

	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link pl.graniec.coralreef.geometry.Vector2#angle(float, float)}.
	 */
	public void testAngle() {
		assertEquals(0f, Vector2.angle(1, 0), 0.0001f);
		assertEquals(45f, Vector2.angle(1, 1), 0.0001f);
		assertEquals(90f, Vector2.angle(0, 1), 0.0001f);
		assertEquals(135f, Vector2.angle(-1, 1), 0.0001f);
		assertEquals(180f, Vector2.angle(-1, 0), 0.0001f);
		assertEquals(-135f, Vector2.angle(-1, -1), 0.0001f);
		assertEquals(-90f, Vector2.angle(0, -1), 0.0001f);
		assertEquals(-45f, Vector2.angle(1, -1), 0.0001f);
	}
	
	public void testCreateFromAngle() {
		Vector2 v;
		
		v = new Vector2(0f);
		
		assertEquals(1f, v.x, 0.0001f);
		assertEquals(0f, v.y, 0.0001f);
		
		v = new Vector2(90f);
		
		assertEquals(0f, v.x, 0.0001f);
		assertEquals(1f, v.y, 0.0001f);
		
		v = new Vector2(180f);
		
		assertEquals(-1f, v.x, 0.0001f);
		assertEquals(0f, v.y, 0.0001f);
		
		v = new Vector2(270f);
		
		assertEquals(0f, v.x, 0.0001f);
		assertEquals(-1f, v.y, 0.0001f);
	}
	
	public void testNormalize() {
		Vector2 v1, v2;
		
		v1 = new Vector2(5, 10);
		v2 = new Vector2(v1);
		
		v2.normalize();
		
		assertEquals(v1.angle(), v2.angle(), 0.001f);
	}

}

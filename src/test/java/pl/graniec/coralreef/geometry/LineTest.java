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
 * @author chudy
 *
 */
public class LineTest extends TestCase {

	/**
	 * Test method for {@link pl.graniec.coralreef.geometry.Line#Line(pl.graniec.coralreef.geometry.Point2, pl.graniec.coralreef.geometry.Point2)}.
	 */
	public void testLinePoint2Point2() {
		final Line line = new Line(new Point2(1, 2), new Point2(3, 3));
		
		assertEquals(1, line.a, 0.0001f);
		assertEquals(-2, line.b, 0.0001f);
		assertEquals(3, line.c, 0.0001f);
	}
	
	public void testLineSegment() {
		final Line line = new Line(new Segment(new Point2(1, 2), new Point2(3, 3)));
		
		assertEquals(1, line.a, 0.0001f);
		assertEquals(-2, line.b, 0.0001f);
		assertEquals(3, line.c, 0.0001f);
	}

}

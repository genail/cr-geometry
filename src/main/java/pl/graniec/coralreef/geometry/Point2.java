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
 * Point in two dimensional space.
 * 
 * @author Piotr Korzuszek <piotr.korzuszek@gmail.com>
 *
 */
public class Point2 extends Vector2 {

	public Point2(final float x, final float y) {
		super(x, y);
	}

	public Point2(Point2 other) {
		super(other.x, other.y);
	}

	/**
	 * Calculates the distance from this point to given <code>line</code>.
	 * @param line The line.
	 * @return Distance to the line.
	 */
	public final float distanceTo(Line line) {
		return (float) (
				Math.abs(line.a * x + line.b * y + line.c)
				/ Math.sqrt(line.a * line.a + line.b * line.b)
		);
	}

	public final float distanceTo(Point2 other) {
		return Vector2.length(this.x - other.x, this.y - other.y);
	}
	
	/**
	 * Calculates the distance from this point to given <code>segment</code>.
	 * <p>
	 * Given result is a distance to the closest point on this segment.
	 * 
	 * @param segment The segment.
	 * @return Distance to given segment.
	 */
	public final float distanceTo(Segment segment) {
		final float b = segment.length();
		final float bb = b * b;
		
		final float c1 = Vector2.length(this.x - segment.x1, this.y - segment.y1);
		final float c2 = Vector2.length(this.x - segment.x2, this.y - segment.y2);
		
		final float c1c1 = c1 * c1;
		final float c2c2 = c2 * c2;
		
		// check if there is perpendicular line that connects this point with segment
		if (c2c2 <= bb + c1c1 && c1c1 <= bb + c2c2) {
			// get distance to line
			return distanceTo(new Line(segment));
		}
		else {
			// lower distance to point
			return c1 < c2 ? c1 : c2;
		}
		
	}
	
	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2 other = (Point2) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		return true;
	}
	
	public final void set(Point2 other) {
		set(other.x, other.y);
	}
	
	/*
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return Point2.class.getSimpleName() + "[x=" + x + ",y=" + y + "]";
	}

}

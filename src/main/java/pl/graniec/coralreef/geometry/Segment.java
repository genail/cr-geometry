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
public class Segment {
	
	public static final float length(final float x1, final float y1, final float x2, final float y2) {
		
		final float w = Math.abs(x2 - x1);
		final float h = Math.abs(y2 - y1);
		
		return (float) StrictMath.sqrt(w * w + h * h);
	}
	
	/** Two segment points */
	public float x1, y1, x2, y2;

	public Segment(float x1, float y1, float x2, float y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public Segment(Point2 p1, Point2 p2) {
		this(p1.x, p1.y, p2.x, p2.y);
	}
	
	/**
	 * Tests if this and the <code>other</code> segments intersects
	 * and retrieves the cross point if there is one. If not, the
	 * <code>null</code> value is returned.
	 * <p>
	 * Segments that has common ends are treated as not-crossing.
	 * 
	 * @param other Other segment to test
	 * 
	 * @return point of intersection or <code>null</code> if there is none.
	 * 
	 * @see #intersects(Segment)
	 * 
	 */
	public final Point2 intersectionPoint(final Segment other) {
		
		// intersection point
		float thisLength = length();
		float otherLength = other.length();
		
		// no intersection when one of segments is zero-length
		if (thisLength == 0.0f || otherLength == 0.0f) {
			return null;
		}
		
		// fail when the segments share an end-point
		if (
				x1 == other.x1 && y1 == other.y1 ||
				x1 == other.x2 && y1 == other.y2 ||
				x2 == other.x1 && y2 == other.y1 ||
				x2 == other.x2 && y2 == other.y2
		    ) {
			return null;
		}
		
		// make a translation so this.x1 this.y1 would be on the origin.
		float thisX2 = x2 - x1;
		float thisY2 = y2 - y1;
		float otherX1 = other.x1 - x1;
		float otherY1 = other.y1 - y1;
		float otherX2 = other.x2 - x1;
		float otherY2 = other.y2 - y1;
		
		// rotate the system so second point of first segment is on the positive X axis
		final float cos = thisX2 / thisLength;
		final float sin = thisY2 / thisLength;
		
		float newX = otherX1 * cos + otherY1 * sin;
		
		otherY1 = otherY1 * cos - otherX1 * sin;
		otherX1 = newX;
		
		newX = otherX2 * cos + otherY2 * sin;
		
		otherY2 = otherY2 * cos - otherX2 * sin;
		otherX2 = newX;
		
		// fail if second segment doesn't cross the line of first segment
		if (otherY1 < 0f && otherY2 < 0 || otherY1 >= 0 && otherY2 >= 0) {
			return null;
		}
		
		// discover the position of intersection point on first segment
		final float iPos = otherX2 + (otherX1 - otherX2) * otherY2 / (otherY2 - otherY1);
		
		// fail if second segment crosses the line of first segment outside of it
		if (iPos < 0f || iPos > thisLength) {
			return null;
		}
		
		// apply the discovered position to original coordinate system
		// and return the result
		return new Point2(
				x1 + iPos * cos,
				y1 + iPos * sin
		);
		
	}

	/**
	 * Checks if there is intersection between this segment
	 * and <code>other</code> one.
	 * 
	 * @param other The other segment.
	 * 
	 * @return <code>true</code> if there is a intersection.
	 * 
	 * @see #intersectionPoint(Segment)
	 */
	public boolean intersects(Segment other) {
		return intersectionPoint(other) != null;
	}
	
	public final float length() {
		return length(x1, y1, x2, y2);
	}

	public String toString() {
		return Segment.class.getSimpleName() + "[x1=" + x1 + ",y1=" + y1 + ",x2=" + x2 + ",y2=" + y2 + "]";
	}
}

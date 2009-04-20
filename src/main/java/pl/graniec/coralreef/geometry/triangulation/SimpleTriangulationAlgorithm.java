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
package pl.graniec.coralreef.geometry.triangulation;

import pl.graniec.coralreef.geometry.Geometry;
import pl.graniec.coralreef.geometry.Point2;
import pl.graniec.coralreef.geometry.Triangle;
import pl.graniec.coralreef.geometry.Vector2;
import pl.graniec.coralreef.geometry.VerticlesOrder;
import pl.graniec.coralreef.math.CoralReefMath;

/**
 * @author Piotr Korzuszek <piotr.korzuszek@gmail.com>
 *
 */
public class SimpleTriangulationAlgorithm implements TriangulationAlgorithm {

	/**
	 * Verticle information useful for triangulation.
	 */
	private static class Verticle extends Point2 {

		boolean ear;
		
		public Verticle(float x, float y) {
			super(x, y);
		}
		
	}
	
	static final float getAngleDifference(final float from, final float to) {
		final float transCurrent = to - from;
		
		if (transCurrent > 180.0f) {
			return -180.0f + (transCurrent - 180.0f);
		} else if (transCurrent < -180.0f) {
			return 180.0f + (transCurrent + 180.0f);
		}
		
		return transCurrent;
	}

//	private float fixAngle(final float angle) {
//		if (angle >= 0) {
//			return angle - 180;
//		} else {
//			return angle + 180;
//		}
//	}
	
	static final VerticlesOrder getVerticlesOrder(Geometry geometry) {
		
		float totalAngle = 0f;
		
		// add all verticle angles
		final Point2[] verticles = geometry.getVerticles();
		
		Point2 prevPoint, currPoint, nextPoint;
		Vector2 prevVec, nextVec;
		float prevAngle, nextAngle;
		
		for (int i = 0; i < verticles.length; ++i ) {
			prevPoint = verticles[index(i - 1, verticles)];
			currPoint = verticles[index(i + 0, verticles)];
			nextPoint = verticles[index(i + 1, verticles)];
			
			// make vectors of this segments
			prevVec = new Vector2(currPoint.x - prevPoint.x, currPoint.y - prevPoint.y);
			nextVec = new Vector2(nextPoint.x - currPoint.x, nextPoint.y - currPoint.y);
			
			// Get the angles. Let's say that 180 angle is 0 and little difference will
			// be given as aberration
			prevAngle = prevVec.angle();
			nextAngle = nextVec.angle();
			
			totalAngle += getAngleDifference(prevAngle, nextAngle);
		}
		
		return CoralReefMath.equals(totalAngle, 360f, 1f) ? VerticlesOrder.CCW : VerticlesOrder.CW;
	}
	
	static final <Arr> int index(int i, Arr[] array) {
		while (i < 0) {
			i += array.length;
		}
		
		if (i >= array.length) {
			return i % array.length;
		}
		
		return i;
	}
	
	/*
	 * @see pl.graniec.coralreef.geometry.triangulation.TriangulationAlgorithm#triangulate(pl.graniec.coralreef.geometry.Geometry)
	 */
	public Triangle[] triangulate(Geometry geometry) {
		// determine the verticles ordering
		final VerticlesOrder verticlesOrder = getVerticlesOrder(geometry);
		
		return null;
	}
	
	public static void main(String[] args) {
		
		final Geometry geometry = new Geometry();
		
		geometry.addVerticle(new Point2(0, 0));
		geometry.addVerticle(new Point2(1, 1));
		geometry.addVerticle(new Point2(2, 0));
		geometry.addVerticle(new Point2(3, 2));
		geometry.addVerticle(new Point2(1, 4));
		
		System.out.println(getVerticlesOrder(geometry));
		
	}

}

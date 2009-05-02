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

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Geometry in two dimensional space.
 * @author Piotr Korzuszek <piotr.korzuszek@gmail.com>
 *
 */
public class Geometry {
	/** Verticles that creates this geometry */
	protected final List verticles = new LinkedList();
	
	public Geometry() {
	}
	
	/**
	 * The copy constructor of Geometry object. It creates a
	 * new geometry from totally new {@link Point2} objects so
	 * two copies can act separately.
	 * 
	 * @param other The other Geometry object to copy.
	 */
	public Geometry(final Geometry other) {
		for (final Iterator itor = other.verticles.iterator(); itor.hasNext();) {
			verticles.add(new Point2((Point2) itor.next()));
		}
	}
	
	public void addVerticle(Point2 point) {
		verticles.add(point);
	}
	
	public void addVerticles(Collection verticles) {
		verticles.addAll(verticles);
	}
	
	public void addVerticles(Point2[] points) {
		for (int i = 0; i < points.length; ++i) {
			verticles.add(points[i]);
		}
	}
	
	public Point2[] getVerticles() {
		return (Point2[]) verticles.toArray(new Point2[verticles.size()]);
	}
	
	/*
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return Geometry.class.getSimpleName() + "[verticles=" + verticles + "]";
	}
	
	/**
	 * Translates coordinates of all verticles by <code>x</code> and
	 * <code>y</code>.
	 * 
	 * @param x The translation value for X coordinate.
	 * @param y The translation value for Y coordinate.
	 */
	public void translate(float x, float y) {
		for (final Iterator itor = verticles.iterator(); itor.hasNext();) {
			final Point2 p = (Point2) itor.next();
			p.x += x;
			p.y += y;
		}
	}
}

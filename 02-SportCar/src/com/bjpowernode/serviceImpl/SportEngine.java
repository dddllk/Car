package com.bjpowernode.serviceImpl;

import com.bjpowernode.service.Engine;

/**
 * Created by dlkyy on 2021-02-08 16:09
 */
public class SportEngine implements Engine {
	@Override
	public void run() {
		System.out.println("0-100km只需4s");
	}
}

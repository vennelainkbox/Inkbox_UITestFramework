import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.print.attribute.IntegerSyntax;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;

import Inkbox.Pages.ProductsPage;

public class Base {

	public static void main(String[] args) throws IOException {

		
		ArrayList<Double> integers = new ArrayList<Double>();

		integers.add((double)1.2);
		integers.add((double) 2);
		integers.add((double) 3.5);
		integers.add((double) 3);
		integers.add((double) 4);
		integers.add((double) 6);
		integers.add((double) 5);
	for (int i = 0; i < integers.size() - 1; i++) {
		
		if (integers.get(i) > integers.get(i + 1)) {
			System.out.println("false :" + integers.get(i));
		}
	}

		
		
//		for (int i = 0; i < integers.size() - 1; i++) {
//			// integers.get(i);
//			if (integers.get(i) > integers.get(i + 1)) {
//				System.out.println("false :" + integers.get(i));
//			}
//
//		}
		
		


	}
	
}

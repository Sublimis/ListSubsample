[![Release](https://jitpack.io/v/Sublimis/ListSubsample.svg)](https://jitpack.io/#Sublimis/ListSubsample)

# ListSubsample

Fast and simple "Min/max" sub-sampling of a (possibly segmented) list coercible to a two-dimensional (*X/Y*) chart of `double`-s.

Create an instance of this class by passing your [`List<List<T>>`](https://developer.android.com/reference/java/util/List) and a [`ILSTransformer<T>`](https://github.com/Sublimis/ListSubsample/blob/master/app/src/main/java/lib/sublimis/subsample/ILSTransformer.java) of your type `T` to the constructor.

`Null` elements are not permitted.

Input list(s) are assumed to be sorted by *X*-values in ascending order!


## Results

Original list had about 10 000 points. Chart width is about 1000 pixels.

### Bucket size = 10
(10 points per bucket, thus the subsampled list is about 10x smaller)

![com.github.sublimis.listsubsample_1000_points.png](https://github.com/Sublimis/ListSubsample/blob/master/images/com.github.sublimis.listsubsample_1000_points.png)

### Bucket size = 100
(100 points per bucket, thus the subsampled list is about 100x smaller)

![com.github.sublimis.listsubsample_100_points.png](https://github.com/Sublimis/ListSubsample/blob/master/images/com.github.sublimis.listsubsample_100_points.png)

### Bucket size = 1000
(1000 points per bucket, thus the subsampled list is about 1000x smaller)

![com.github.sublimis.listsubsample_10_points.png](https://github.com/Sublimis/ListSubsample/blob/master/images/com.github.sublimis.listsubsample_10_points.png)


## About the algorithm

Complexity of the algorithm is just **O(n)**.

Proceeding through the input data, elements are being divided into buckets (by X-value).
For each bucket a minimum element and a maximum element (by Y-value) is found, and added to the output (in their original X-order).

Two input segments will be merged in the output unless they are separated by more than the bucket size.


## To use this as a library in your app

Add the following line to your `build.gradle` file:

```groovy
implementation 'com.github.Sublimis:ListSubsample:v2.1'
```

You can find more info at [https://jitpack.io/#Sublimis/ListSubsample](https://jitpack.io/#Sublimis/ListSubsample).


## Example

```java
final List<List<T>> inputData = ...;    // Your data with elements of type T

final double bucketSize = 10;           // Adjust the bucket size according to your needs

final List<List<T>> sample = new ListSubsample<T>(inputData,
	new ILSTransformer<T>()
	{
		@Override
		public double getX(final T entry)
		{
			return entry.getX();
		}

		@Override
		public double getY(final T entry)
		{
			return entry.getY();
		}
	})
	.getSubsample(bucketSize);
```

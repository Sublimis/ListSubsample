/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package lib.sublimis.subsample;

import java.util.List;


/**
 * @author Sublimis
 * @version 3.0 (2024-04-04)
 */
public class LSUtils
{
	public static <E> E getFirst(final List<E> list)
	{
		E retVal = null;

		if (list != null && !list.isEmpty())
		{
			retVal = list.get(0);
		}

		return retVal;
	}

	public static <E> E getFirstFirst(final List<List<E>> listList)
	{
		E retVal = null;

		if (isValidAndNotEmpty(listList))
		{
			for (final List<E> list : listList)
			{
				retVal = getFirst(list);

				if (retVal != null)
				{
					break;
				}
			}
		}

		return retVal;
	}

	public static <E> E getLast(final List<E> list)
	{
		E retVal = null;

		if (list != null && !list.isEmpty())
		{
			retVal = list.get(list.size() - 1);
		}

		return retVal;
	}

	public static <E> void addFirst(final List<E> list, final E element)
	{
		if (list != null)
		{
			list.add(0, element);
		}
	}

	public static <E> void addLast(final List<E> list, final E element)
	{
		if (list != null)
		{
			list.add(element);
		}
	}

	public static <E> boolean isValidAndNotEmpty(final List<E> list)
	{
		boolean retVal = false;

		if (list != null)
		{
			retVal = false == list.isEmpty();
		}

		return retVal;
	}

	public static <E> LSPair<E, E> getRange(final List<List<E>> listList)
	{
		LSPair<E, E> output = null;

		if (listList != null)
		{
			List<E> firstSegment = null;
			{
				for (final List<E> list : listList)
				{
					if (isValidAndNotEmpty(list))
					{
						firstSegment = list;
						break;
					}
				}
			}

			List<E> lastSegment = null;
			{
				for (int i = listList.size() - 1; i >= 0; i--)
				{
					final List<E> list = listList.get(i);

					if (isValidAndNotEmpty(list))
					{
						lastSegment = list;
						break;
					}
				}
			}

			if (isValidAndNotEmpty(firstSegment) && isValidAndNotEmpty(lastSegment))
			{
				output = LSPair.create(getFirst(firstSegment), getLast(lastSegment));
			}
		}

		return output;
	}

	public static <E> int getPointsCount(final List<List<E>> listList)
	{
		int output = 0;

		if (listList != null)
		{
			for (final List<E> list : listList)
			{
				output += list.size();
			}
		}

		return output;
	}
}

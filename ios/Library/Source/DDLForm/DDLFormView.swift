/**
* Copyright (c) 2000-present Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
import UIKit

public class DDLFormView: BaseWidgetView, UITextFieldDelegate {

	public var rows: [DDLElement] = [] {
		didSet {
			onChangedRows()
		}
	}

	public var values: [String:AnyObject] {
		get {
			var result:[String:AnyObject] = [:]

			for (index, element) in enumerate(rows) {
				if let value:AnyObject = element.currentValue {
					result[element.name] = value
				}
			}

			return result
		}
	}

	internal func onChangedRows() {
	}

}
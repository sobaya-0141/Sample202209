//
//  ObservableExtensions.swift
//  iosApp
//
//  Created by sobaya-0141 on 2022/10/19.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation

import shared



public extension RandomDogGridViewModel {

    func asObserveableObject() -> RandomDogGridViewModelObservableObject{
        return RandomDogGridViewModelObservableObject(wrapped: self)
    }
}

public extension SearchCatViewModel {

    func asObserveableObject() -> SearchCatViewModelObservableObject{
        return SearchCatViewModelObservableObject(wrapped: self)
    }
}

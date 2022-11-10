//
//  ObservableExtensions.swift
//  iosApp
//
//  Created by sobaya-0141 on 2022/10/19.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation

import shared



public extension FeaturesRandomDogGridViewModel {

    func asObserveableObject() -> RandomDogGridViewModelObservableObject{
        return RandomDogGridViewModelObservableObject(wrapped: self)
    }
}

public extension FeaturesSearchCatViewModel {

    func asObserveableObject() -> SearchCatViewModelObservableObject{
        return SearchCatViewModelObservableObject(wrapped: self)
    }
}

//
//  SearchCatViewModelObservableObject.swift
//  iosApp
//
//  Created by 霜重 健児 on 2022/11/09.
//  Copyright © 2022 orgName. All rights reserved.
//
import Foundation
import Combine
import shared

public class SearchCatViewModelObservableObject : ObservableObject {

    var viewModel : FeaturesSearchCatViewModel

    @Published private(set) var state: Any


    init(wrapped: FeaturesSearchCatViewModel) {
        viewModel = wrapped
        state = wrapped.catData.value as! Any
        (wrapped.catData.asPublisher() as AnyPublisher<Any, Never>)
            .receive(on: RunLoop.main)
            .assign(to: &$state)


    }
}

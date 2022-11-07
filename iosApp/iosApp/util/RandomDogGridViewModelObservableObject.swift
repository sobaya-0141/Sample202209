//
//  RandomDogGridViewModelObservableObject.swift
//  iosApp
//
//  Created by sobaya-0141 on 2022/10/19.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import Combine
import shared

public class RandomDogGridViewModelObservableObject : ObservableObject {

    var viewModel : FeaturesRandomDogGridViewModel

    @Published private(set) var state: UtilResult


    init(wrapped: FeaturesRandomDogGridViewModel) {
        viewModel = wrapped
        state = wrapped.randomDog.value as! UtilResult
        (wrapped.randomDog.asPublisher() as AnyPublisher<UtilResult, Never>)
            .receive(on: RunLoop.main)
            .assign(to: &$state)


    }
}

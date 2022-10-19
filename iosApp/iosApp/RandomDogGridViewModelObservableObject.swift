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

    @Published private(set) var state: FeaturesSwRandomDogGridState


    init(wrapped: FeaturesRandomDogGridViewModel) {
        viewModel = wrapped
        state = wrapped.swState.value as! FeaturesSwRandomDogGridState
        (wrapped.swState.asPublisher() as AnyPublisher<FeaturesSwRandomDogGridState, Never>)
            .receive(on: RunLoop.main)
            .assign(to: &$state)


    }
}

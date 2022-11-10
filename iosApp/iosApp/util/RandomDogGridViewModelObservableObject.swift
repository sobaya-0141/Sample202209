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

    @Published private(set) var state: FlowResult


    init(wrapped: FeaturesRandomDogGridViewModel) {
        viewModel = wrapped
        let randomDpg: Kotlinx_coroutines_coreStateFlow = wrapped.randomDog
        state = randomDpg.value as! FlowResult
        (randomDpg.asPublisher() as AnyPublisher<FlowResult, Never>)
            .receive(on: RunLoop.main)
            .assign(to: &$state)


    }
}

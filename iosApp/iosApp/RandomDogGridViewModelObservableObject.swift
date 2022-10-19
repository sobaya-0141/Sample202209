import Foundation
import Combine
import shared

public class RandomDogGridViewModelObservableObject : ObservableObject {
    
    var viewModel : RandomDogGridViewModel

    @Published private(set) var state: SwRandomDogGridState
    

    init(wrapped: RandomDogGridViewModel) {

        viewModel = wrapped
        state = wrapped.swState.value as! SwRandomDogGridState
        (wrapped.swState.asPublisher() as AnyPublisher<SwRandomDogGridState, Never>)
            .receive(on: RunLoop.main)
            .assign(to: &$state)


    }
    

    
}

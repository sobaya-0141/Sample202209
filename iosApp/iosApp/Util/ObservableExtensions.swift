import Foundation


import shared



public extension FeaturesRandomDogGridViewModel {

    func asObservableObject() -> FeaturesRandomDogGridViewModel{
        return RandomDogGridViewModelObservableObject(wrapped: self)
    }

}
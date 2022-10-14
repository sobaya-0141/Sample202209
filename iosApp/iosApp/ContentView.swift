import SwiftUI
import shared

struct ContentView: View {
    let dogs = GetRandomDogUseCaseHelper().getRandomDogUseCase()

	var body: some View {
        ForEach(dogs) { dog in
            Text(dog)
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

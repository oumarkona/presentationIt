
@Component({   
	selector: 'app-root',
	template: `<h1>{{ title }} </h1>
				<div>
					<h2>{{ bookmark.titre }}</h2>
					<img [src]="bookmark.url"/>
				</div>` 
}) 
export class PostAppComponent {
	title: string = 'Publications';

	constructor(LIST_PUBLICATIONS: Array<Post>) {}

	search(titleLike: string): Array<Post> {
		return this.LIST_PUBLICATIONS.filter((pub: Post) => pub.title.startsWith(titleLike));
	}

}

@Component({   
	selector: 'app-root',
	templateUrl: 'app.component.html',
	styleUrls: ['app.component.scss', 'app.component.other.scss'],
	providers: [ PostService ],
    encapsulation: ViewEncapsulation.Emulate
    // ...
}) 
export class PostAppComponent {

}





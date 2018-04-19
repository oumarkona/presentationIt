import { Component, OnInit } from '@angular/core';

interface Post {
	id: number;
	titre: string;
	content?: string;
	createdAt?: Date;
	updateAt?: Date;
}

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {

	posts: Array<Post>;

  constructor() { }

  ngOnInit() {
  	this.posts = [
  		{id: 1, titre: "Pub 1", content: "Pub 1"},
  		{id: 2, titre: "Pub 2", content: "Pub 2"},
  		{id: 3, titre: "Pub 3", content: "Pub 3"},
  	];
  }

}
